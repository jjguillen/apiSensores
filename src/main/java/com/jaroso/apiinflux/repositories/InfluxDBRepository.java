package com.jaroso.apiinflux.repositories;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxTable;
import com.jaroso.apiinflux.entities.Sensor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public class InfluxDBRepository {

    private final InfluxDBClient influxDBClient;
    private final SensorRepository sensorRepository;

    @Value("${influx.bucket}")
    private String bucket;

    @Value("${influx.org}")
    private String org;

    public InfluxDBRepository(InfluxDBClient influxDBClient, SensorRepository sensorRepository) {
        this.influxDBClient = influxDBClient;
        this.sensorRepository = sensorRepository;
    }

    // Método para escribir datos en InfluxDB
    public void saveData(Long sensorId, double value) {
        //Get the sensor from DB
        Sensor sensor = sensorRepository.findById(sensorId).orElseThrow();

        WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();

        //En este caso indicamos que el sensor es de temperatura
        Point point = Point.measurement(sensor.getTipo().toString())
                .addTag("sensorId", String.valueOf(sensorId))
                .addField("value", value)
                .time(Instant.now(), WritePrecision.MS);

        writeApi.writePoint(bucket, org, point);
    }

    // Método para leer datos desde InfluxDB
    public List<FluxTable> getDataBySensorId(Long sensorId) {
        //Modificar el rango de tiempo si es necesario
        String query = String.format(
                "from(bucket: \"%s\") |> range(start: -1h) |> filter(fn: (r) => r[\"sensorId\"] == \"%s\")",
                bucket, sensorId);

        return influxDBClient.getQueryApi().query(query, org);
    }
}

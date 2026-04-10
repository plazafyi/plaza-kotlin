// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RouteRequestTest {

    @Test
    fun create() {
        val routeRequest =
            RouteRequest.builder()
                .destination(
                    PointGeometry.builder()
                        .addCoordinate(2.2945)
                        .addCoordinate(48.8584)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .origin(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .alternatives(0L)
                .annotations(true)
                .departAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ev(
                    RouteRequest.Ev.builder()
                        .batteryCapacityWh(75000.0)
                        .addConnectorType("string")
                        .initialChargePct(0.0)
                        .minChargePct(0.0)
                        .minPowerKw(0.0)
                        .build()
                )
                .exclude("exclude")
                .geometries(RouteRequest.Geometries.GEOJSON)
                .mode(RouteRequest.Mode.AUTO)
                .overview(RouteRequest.Overview.FULL)
                .steps(true)
                .trafficModel(RouteRequest.TrafficModel.BEST_GUESS)
                .addWaypoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .build()

        assertThat(routeRequest.destination())
            .isEqualTo(
                PointGeometry.builder()
                    .addCoordinate(2.2945)
                    .addCoordinate(48.8584)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(routeRequest.origin())
            .isEqualTo(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(routeRequest.alternatives()).isEqualTo(0L)
        assertThat(routeRequest.annotations()).isEqualTo(true)
        assertThat(routeRequest.departAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(routeRequest.ev())
            .isEqualTo(
                RouteRequest.Ev.builder()
                    .batteryCapacityWh(75000.0)
                    .addConnectorType("string")
                    .initialChargePct(0.0)
                    .minChargePct(0.0)
                    .minPowerKw(0.0)
                    .build()
            )
        assertThat(routeRequest.exclude()).isEqualTo("exclude")
        assertThat(routeRequest.geometries()).isEqualTo(RouteRequest.Geometries.GEOJSON)
        assertThat(routeRequest.mode()).isEqualTo(RouteRequest.Mode.AUTO)
        assertThat(routeRequest.overview()).isEqualTo(RouteRequest.Overview.FULL)
        assertThat(routeRequest.steps()).isEqualTo(true)
        assertThat(routeRequest.trafficModel()).isEqualTo(RouteRequest.TrafficModel.BEST_GUESS)
        assertThat(routeRequest.waypoints())
            .containsExactly(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routeRequest =
            RouteRequest.builder()
                .destination(
                    PointGeometry.builder()
                        .addCoordinate(2.2945)
                        .addCoordinate(48.8584)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .origin(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .alternatives(0L)
                .annotations(true)
                .departAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ev(
                    RouteRequest.Ev.builder()
                        .batteryCapacityWh(75000.0)
                        .addConnectorType("string")
                        .initialChargePct(0.0)
                        .minChargePct(0.0)
                        .minPowerKw(0.0)
                        .build()
                )
                .exclude("exclude")
                .geometries(RouteRequest.Geometries.GEOJSON)
                .mode(RouteRequest.Mode.AUTO)
                .overview(RouteRequest.Overview.FULL)
                .steps(true)
                .trafficModel(RouteRequest.TrafficModel.BEST_GUESS)
                .addWaypoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .build()

        val roundtrippedRouteRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(routeRequest),
                jacksonTypeRef<RouteRequest>(),
            )

        assertThat(roundtrippedRouteRequest).isEqualTo(routeRequest)
    }
}

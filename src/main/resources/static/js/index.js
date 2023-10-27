/**
 * @license
 * Copyright 2019 Google LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
// [START maps_add_map]
// Initialize and add the map
let map;


async function initMap() {
    // [START maps_add_map_instantiate_map]
    // The location of Uluru
    const position = { lat: 100.344, lng: 131.031 };
    // Request needed libraries.
    //@ts-ignore
    const { Map } = await google.maps.importLibrary("maps");
    const { AdvancedMarkerView } = await google.maps.importLibrary("marker");

    // The map, centered at Uluru
    map = new Map(document.getElementById("default_map"), {
        zoom: 4,
        center: position,
        mapId: "DEMO_MAP_ID",
    });

    //END maps_add_map_instantiate_map]
}

initMap();

// [END maps_add_map]
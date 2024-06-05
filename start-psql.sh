#!/bin/sh
docker run --rm  -e POSTGRES_PASSWORD=IloveOpenShift4 -e POSTGRES_USER=redhat -e POSTGRES_DB=rhsi --name postgresql --net=host postgres:16

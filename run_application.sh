#!/bin/bash

# Function to build all services
build_all_services() {
  echo "Building all services..."
  mvn clean package -DskipTests || exit 1
}

# Function to build and start Docker containers using Docker Compose
build_and_start_docker_containers() {
  echo "Building and starting Docker containers..."
  docker-compose up --build
}

build_all_services
build_and_start_docker_containers

# Video Streaming Api

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/antoshaSid/video-streaming-api.git
cd video-streaming-api
```

### 2. Running the Application

To build and start microservices, execute:

```bash
./run_application.sh
```

## Decisions
- Kafka is used as a message broker to handle the communication between the services.
- Flyway is used for database migration.
- PostgreSQL is used as the database.
- Eureka is used for service discovery.

## Possible Improvements
- Implement asynchronous REST API for better performance.
- Implement tests for the services.
- Divide video playing process into chunks to enhance performance.

## Known issues
- Due to lack of time and resources, the project is not fully implemented and may contain issues.

## Api Definition
![Api Definition](images/api_definition.png)

## Service Mapping
![Service Mapping](images/service_mapping.png)

1. **migration-service** - responsible for Flyway migration.
2. **api-gateway-service** - responsible for routing requests to the appropriate service.
3. **eureka-service** - responsible for service discovery.
4. **video-service** - responsible for video management.
5. **video-metadata-service** - responsible for video metadata management.
6. **video-statistic-service** - responsible for video statistics management.

## Service Communication
![Service Communication](images/service_communication.png)

## Data design
![Data design](images/data_design.png)



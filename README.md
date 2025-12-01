# Product Lister Application

A containerized Spring Boot application with PostgreSQL database.

## Prerequisites
- Docker
- Docker Compose

## Quick Start

1. Clone this repository:
```bash
git clone https://github.com/rprakashdass/docker-practice-01-product-lister.git
cd docker-practice-01-product-lister
```

2. Start the application:
```bash
docker-compose up
```

3. Access the application:
- Homepage: http://localhost:8080/
- Products API: http://localhost:8080/products
- Add Product: http://localhost:8080/addProduct

## Stopping the Application

```bash
docker-compose down
```

## Architecture

- **App Container**: Spring Boot application (Port 8080)
- **Postgres Container**: PostgreSQL database (Port 5432)
- **Named Volume**: `postgres-product-data` for data persistence
- **Network**: `product-network` for container communication

## Commands

- `docker-compose up` - Start all services
- `docker-compose up -d` - Start in background
- `docker-compose down` - Stop and remove containers
- `docker-compose logs -f` - View logs
- `docker-compose ps` - List running containers

# Home Ease Project

Home ease microservices.

## Prerequisite (locally)

1. Install Docker.

```bash
https://www.docker.com/products/docker-desktop/
```

2. Build each service (project by project)

```bash
mvn clean package
```

3. Run docker-compose.yaml file

```bash
docker-compose up -d
```

## Services

Service
- Registration service
- Professional service
- Review service

Sync
- Professional inventory service
- Booking service

Async
- Payment service
- Notification service

Other
- Discovery server
- API gateway

## Contributing

Muhammad Arifin Hidayat, Aakash Huilgol

## License

[MIT](https://choosealicense.com/licenses/mit/)
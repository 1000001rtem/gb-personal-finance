[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c5ca9f8ec0f948d58ef53abd6fb1ee2e)](https://www.codacy.com/app/skubatko/gb-personal-finance?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=skubatko/gb-personal-finance&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/skubatko/gb-personal-finance.svg?branch=develop)](https://travis-ci.org/skubatko/gb-personal-finance)
# Personal Finance Service
Team project as the next part of Java development education

Java 8, Spring boot 2.1, Spring Cloud, Spring Cloud Configuration server, Netflix Eureka discovery server, Netflix Zuul, Spring Cloud OpenFeign client, Spring Boot Test, PostgreSQL 10, Vaadin

## Build
`maven clean install`

## Run
Последовательность запуска модулей:
* pfs-server-discovery
* pfs-server-config
* pfs-authentication
* pfs-accounting
* pfs-notification
* pfs-statistics
* pfs-server-gateway
* pfs-ui


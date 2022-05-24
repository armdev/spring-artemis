# spring-artemis
spring jms : producer - consumer

run artemis: docker-compose up -d
from your IDE(netbeans) run producer and consumer

send message from producer to consumer: http://localhost:2076/send

test by Apache Benchmark: ab -n 1000 -c 100 http://localhost:2076/send

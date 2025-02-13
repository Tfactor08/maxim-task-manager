printf "$(curl -X POST localhost:8080/tasks -H "Content-Type: application/json" \
    --silent --show-error \
    -d '{"title": "test-task"}')\n"

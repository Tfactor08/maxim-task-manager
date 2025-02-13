printf "$(curl -X POST localhost:8080/tasks/$1 -H "Content-Type: application/json" \
    --silent --show-error \
    -d '{"title": "changed-title"}')\n"

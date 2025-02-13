if [ $# -eq 0 ]; then
    printf "$(curl -X GET localhost:8080/tasks --silent --show-error)\n"
else
    printf "$(curl -X GET localhost:8080/tasks/$1 --silent --show-error)\n"
fi

FROM golang:alpine AS builder

WORKDIR .

COPY server.go .
RUN go env -w GO111MODULE=off
RUN go build -o server .

FROM alpine
WORKDIR .
COPY --from=builder . .
CMD ["./go/server"]

#ENTRYPOINT ["tail", "-f", "/dev/null"]

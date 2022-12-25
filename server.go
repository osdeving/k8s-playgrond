package main

import (
	"net/http"
	"os"
	"fmt"
)
	

func main() {
	http.HandleFunc("/", Hello)
	http.HandleFunc("/secret", Secret)

	err := http.ListenAndServe(":80", nil)

	if(err != nil) {
		println(err.Error())
	}
}

func Hello(w http.ResponseWriter, r *http.Request) {
	name := os.Getenv("NAME")
	age := os.Getenv("AGE")

	fmt.Fprintf(w, "<h1> Hello, eu sou o %s e tenho %s anos.</h1>", name, age)
}

func Secret(w http.ResponseWriter, r *http.Request) {
	username := os.Getenv("USERNAME")
	password := os.Getenv("PASSWORD")

	fmt.Fprintf(w, "username: %s password: %s", username, password)
}
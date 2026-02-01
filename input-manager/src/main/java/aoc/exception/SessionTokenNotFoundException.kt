package aoc.exception

class SessionTokenNotFoundException :
    RuntimeException("Could not find session token in .env file.")
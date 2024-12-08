// src/logger.js
const winston = require('winston');
require('winston-logstash');

const logger = winston.createLogger({
  transports: [
    new winston.transports.Console(),
    new winston.transports.Logstash({
      host: 'logstash',  // Logstash container hostname in Docker
      port: 5000,
    }),
  ],
});

// Example usage
logger.info('Frontend log message');
logger.error('Frontend error message');

module.exports = logger;

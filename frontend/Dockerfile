# Use Node.js for building and nginx for serving
FROM node:18-alpine AS build
WORKDIR /frontend
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build
EXPOSE 5173
CMD ["npm", "start"]

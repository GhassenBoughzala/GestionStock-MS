FROM node:stretch-slim

# Create app directory
WORKDIR /app

# Install app dependencies
COPY app/package*.json /app/

RUN npm install

COPY . /app

EXPOSE 4401
CMD [ "node", "server.js" ]
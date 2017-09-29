FROM node:latest

RUN mkdir -p /tmp/todo/frontend

WORKDIR /tmp/todo/frontend

COPY package.json /tmp/todo/frontend

RUN npm install

COPY . /tmp/todo/frontend

EXPOSE 4200

CMD ["npm", "start"]





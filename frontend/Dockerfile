FROM node:latest
RUN mkdir -p /tmp/todo/frontend
WORKDIR /tmp/todo/frontend
ADD . /tmp/todo/frontend
RUN npm install
EXPOSE 4200
CMD npm start

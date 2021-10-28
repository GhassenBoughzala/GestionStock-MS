const express = require('express')
const mongoose = require('mongoose')
const foodRouter = require('./routes/livraisonRoute.js')
const eurekaHelper = require('./eureka-helper');
const PORT = process.env.PORT || 4001;
const app = express()

app.use(express.json())

mongoose.connect(
  'mongodb+srv://microservice:microservice@cluster0.hlrlc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority',

  {
    useNewUrlParser: true,
    useFindAndModify: false,
    useUnifiedTopology: true
  }
)

app.use(foodRouter)

app.listen(4001, () => {
  console.log('Server is running...')
})

eurekaHelper.registerWithEureka('Livraison-service', PORT);

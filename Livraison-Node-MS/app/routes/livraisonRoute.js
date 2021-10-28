const express = require('express')
const livraisonModel = require('../models/livraison')
const app = express()
var bodyParser = require('body-parser')

app.use(express.static(__dirname + '/public'))

app.use(
  bodyParser.urlencoded({
    extended: false
  })
)

app.use(bodyParser.json())

app.post('/livraison', async (request, response) => {
  const livraison = new livraisonModel(request.body)

  await livraison.save()
  response.send(livraison)
})

app.get('/livraison', async (request, response) => {
  const livraisons = await livraisonModel.find({})

  response.send(livraisons)
})
app.patch('/livraison/:id', async (request, response) => {
  await livraisonModel.findByIdAndUpdate(request.params.id, request.body)
  await livraisonModel.save()
  response.send(livraisons)
})
app.delete('/livraison/:id', async (request, response) => {
  const livraison = await livraisonModel.findByIdAndDelete(request.params.id)

  if (!livraison) response.status(404).send('No item found')
  response.status(200).send()
})

module.exports = app

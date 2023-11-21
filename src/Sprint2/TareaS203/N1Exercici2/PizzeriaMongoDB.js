db.createCollection('Cliente', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Cliente',
      properties: {
        Nom: {
          bsonType: 'string'
        },
        Cognoms: {
          bsonType: 'string'
        },
        Adressa: {
          bsonType: 'string'
        },
        CodiPostal: {
          bsonType: 'string'
        },
        idLocalitat: {
          bsonType: 'objectId'
        },
        idProvincia: {
          bsonType: 'objectId'
        },
        Telefon: {
          bsonType: 'string'
        }
      }
    }
  }
});
db.createCollection('Comanda', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Comanda',
      required: ['idCliente'],
      properties: {
        idCliente: {
          bsonType: 'objectId'
        },
        DataHora: {
          bsonType: 'date'
        },
        idTipusComanda: {
          bsonType: 'objectId'
        },
        Productes: {
          bsonType: 'array',
          items: {
            bsonType: 'objectId'
          }
        },
        PreuTotal: {
          bsonType: 'double'
        },
        IdBotiga: {
          bsonType: 'objectId'
        }
      }
    }
  }
});
db.createCollection('Producte', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Producte',
      properties: {
        Nom: {
          bsonType: 'string'
        },
        Descripcio: {
          bsonType: 'string'
        },
        imatge: {
          bsonType: 'binData'
        },
        Preu: {
          bsonType: 'double'
        },
        idCategoria: {
          bsonType: 'objectId'
        },
        TipusProducte: {
          enum:
        }
      }
    }
  }
});
db.createCollection('Categoria', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Categoria',
      properties: {
        Nom: {
          bsonType: 'string'
        }
      }
    }
  }
});
db.createCollection('TipusComanda', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'TipusComanda',
      properties: {
        Nom: {
          bsonType: 'string'
        }
      }
    }
  }
});
db.createCollection('Botiga', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Botiga',
      properties: {
        Adressa: {
          bsonType: 'string'
        },
        CodiPostal: {
          bsonType: 'string'
        },
        idLocalitat: {
          bsonType: 'objectId'
        },
        idProvincia: {
          bsonType: 'objectId'
        }
      }
    }
  }
});
db.createCollection('Localitat', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Localitat',
      properties: {
        Nom: {
          bsonType: 'string'
        },
        idProvincia: {
          bsonType: 'objectId'
        }
      }
    }
  }
});
db.createCollection('Provincia', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Provincia',
      properties: {
        Nom: {
          bsonType: 'string'
        }
      }
    }
  }
});




var pr = db.Provincia.insertOne({
  Nom: 'Barcelona'
});

var loc = db.Localitat.insertOne({
  Nom: 'Barcelona',
  idProvincia: pr.insertedId,
});


var cl = db.Cliente.insertOne({
  Nom: 'Juan',
  Cognoms: 'Pérez',
  Adressa: 'Calle Principal 123',
  CodiPostal: '08001',
  idLocalitat: loc.insertedId, 
  idProvincia: pr.insertedId, 
  Telefon: '123456789'
});

var bot = db.Botiga.insertOne({
  Adressa: 'Avenida Principal 456',
  CodiPostal: '08002',
  idLocalitat: loc.insertedId, 
  idProvincia: pr.insertedId 
});

var tipCom = db.TipusComanda.insertOne({
  Nom: 'Recollida a tenda'
});

var cat = db.Categoria.insertOne({
  Nom: 'Pizza'
});


var prod = db.Producte.insertOne({
  Nom: 'Producto 1',
  Descripcio: 'Descripción del producto 1',
  Preu: 19.99,
  idCategoria: cat.insertedId, 
  TipusProducte: 'Tipo 1'
});

db.Comanda.insertOne({
  idCliente: cl.insertedId, 
  DataHora: new Date(),
  idTipusComanda: tipCom.insertedId, 
  Productes: [prod.insertedId], 
  PreuTotal: 50.99,
  IdBotiga: bot.insertedId 
});


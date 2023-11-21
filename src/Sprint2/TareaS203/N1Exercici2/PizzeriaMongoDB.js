use pizzeria;

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
        },
        idEmpleat: {
          bsonType: 'objectId'
        },
        DataLliurament: {
          bsonType: 'date'
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
          enum: ["Beguda", "Hamburguesa", "Pizza"]
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
db.createCollection('Empleat', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Empleat',
      properties: {
        Nom: {
          bsonType: 'string'
        },
        idBotiga: {
          bsonType: 'objectId'
        },
        TipusEmpleat: {
          enum: ["Cuiner", "Repartidor"]
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

var catCalzone = db.Categoria.insertOne({
  Nom: 'Calzone'
});
var catFina = db.Categoria.insertOne({
  Nom: 'Fina'
});
var catRoller = db.Categoria.insertOne({
  Nom: 'Roller'
});


var prodBeg1 = db.Producte.insertOne({
  Nom: 'Beguda 1',
  Descripcio: 'Descripción de Beguda 1',
  Preu: 19.99,
  TipusProducte: 'Beguda'
});
var prodBeg2 = db.Producte.insertOne({
  Nom: 'Beguda 2',
  Descripcio: 'Descripción de Beguda 2',
  Preu: 19.99,
  TipusProducte: 'Beguda'
});
var prodPzCalzone = db.Producte.insertOne({
  Nom: 'Pizza Calzone',
  Descripcio: 'Descripción de Pizza Calzone',
  Preu: 30.99,
  idCategoria: catCalzone.insertedId, 
  TipusProducte: 'Pizza'
});
var prodPzFina = db.Producte.insertOne({
  Nom: 'Pizza Fina',
  Descripcio: 'Descripción de Pizza Fina',
  Preu: 20.99,
  idCategoria: catFina.insertedId, 
  TipusProducte: 'Pizza'
});
var prodPzRoller = db.Producte.insertOne({
  Nom: 'Pizza Roller',
  Descripcio: 'Descripción de Pizza Roller',
  Preu: 25.99,
  idCategoria: catRoller.insertedId, 
  TipusProducte: 'Pizza'
});




var empCuiner = db.Empleat.insertOne({
  Nom: 'Empleado Cuiner',
  idBotiga: bot.insertedId, 
  TipusEmpleat: 'Cuiner'
});

var empRep = db.Empleat.insertOne({
  Nom: 'Empleado Repartidor',
  idBotiga: bot.insertedId, 
  TipusEmpleat: 'Repartidor'
});


db.Comanda.insertOne({
  idCliente: cl.insertedId, 
  DataHora: new Date(),
  idTipusComanda: tipCom.insertedId, 
  Productes: [prodBeg1.insertedId, prodPzFina.insertedId], 
  PreuTotal: 50.99,
  idEmpleat: empRep.insertedId,
  DataLliurament: new Date(),
  IdBotiga: bot.insertedId 
});

db.Comanda.insertOne({
  idCliente: cl.insertedId, 
  DataHora: new Date(),
  idTipusComanda: tipCom.insertedId, 
  Productes: [prodBeg2.insertedId, prodPzCalzone.insertedId, prodBeg1.insertedId, prodPzRoller.insertedId, prodPzFina.insertedId], 
  PreuTotal: 50.99,
  idEmpleat: empRep.insertedId,
  DataLliurament: new Date(),
  IdBotiga: bot.insertedId 
});

db.createCollection('Proveedor', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Proveedor',
      properties: {
        nombre: {
          bsonType: 'string'
        },
        adressa: {
          bsonType: 'object',
          title: 'object',
          properties: {
            carrer: {
              bsonType: 'string'
            },
            numero: {
              bsonType: 'int'
            },
            pis: {
              bsonType: 'string'
            },
            porta: {
              bsonType: 'string'
            },
            ciutat: {
              bsonType: 'string'
            },
            codi_postal: {
              bsonType: 'string'
            },
            pais: {
              bsonType: 'string'
            }
          }
        },
        telefon: {
          bsonType: 'string'
        },
        fax: {
          bsonType: 'string'
        },
        NIF: {
          bsonType: 'string'
        },
        id_ullera: {
          bsonType: 'array',
          items: {
            bsonType: 'objectId'
          }
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('Clientes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Clientes',
      properties: {
        nom: {
          bsonType: 'string'
        },
        adressa: {
          bsonType: 'string'
        },
        telefon: {
          bsonType: 'string'
        },
        email: {
          bsonType: 'string'
        },
        dataRegistre: {
          bsonType: 'date'
        },
        ClientRecomanat: {
          bsonType: 'objectId'
        }
      }
    }
  }
});
db.createCollection('Venda', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Venda',
      properties: {
        id_ullera: {
          bsonType: 'array',
          items: {
            bsonType: 'objectId'
          }
        },
        idClient: {
          bsonType: 'objectId'
        },
        idVenedor: {
          bsonType: 'objectId'
        }
      }
    }
  }
});
db.createCollection('ulleres', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'ulleres',
      properties: {
        marca: {
          bsonType: 'string'
        },
        GradVE: {
          bsonType: 'double'
        },
        GradVD: {
          bsonType: 'double'
        },
        TipusMontura: {
          enum: ["Flotant", "Metalica", "Pasta"]
        },
        colorMontura: {
          bsonType: 'string'
        },
        colorVE: {
          bsonType: 'string'
        },
        colorVD: {
          bsonType: 'string'
        },
        preu: {
          bsonType: 'double'
        }
      }
    }
  }
});
db.createCollection('Venedor', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Venedor',
      properties: {
        nom: {
          bsonType: 'string'
        }
      }
    }
  }
});




// ulleres
db.ulleres.insertOne({
  marca: "Marca1",
  GradVE: 2.5,
  GradVD: 1.5,
  TipusMontura: "Flotant",
  colorMontura: "Negro",
  colorVE: "Azul",
  colorVD: "Verde",
  preu: 150.50
});

// Venedor
db.Venedor.insertOne({
  nom: "Vendedor1"
});

// Proveedor
db.Proveedor.insertOne({
  nombre: "Proveedor1",
  adressa: {
    carrer: "Calle Proveedor",
    numero: 123,
    pis: "2",
    porta: "B",
    ciutat: "Ciudad Proveedor",
    codi_postal: "12345",
    pais: "Pais Proveedor"
  },
  telefon: "123456789",
  fax: "987654321",
  NIF: "A12345678",
  id_ullera: ObjectId("5fbc39be2a7a3b9b1c996db9")
});

// Clientes
db.Clientes.insertOne({
  nom: "Cliente1",
  adressa: "Calle Cliente",
  telefon: "987654321",
  email: "cliente1@example.com",
  dataRegistre: new Date(),
  ClientRecomanat: ObjectId("5fbc39be2a7a3b9b1c996dbe")
});

// Venda
db.Venda.insertOne({
  id_ullera: [ObjectId("5fbc39be2a7a3b9b1c996db9")],
  idClient: ObjectId("5fbc39be2a7a3b9b1c996dbe"),
  idVenedor: ObjectId("5fbc39be2a7a3b9b1c996dbd")
});


var v1 = db.Venedor.find({},{_id:1});
var c1
db.Venda.insertOne({id_ullera: [
	db.ulleres.findOne({},{_id:1})
	],idClient: 
	db.Clientes.find({nom:"Cliente1"},{_id:1})
	,idVenedor: 
	db.Venedor.find({nom:"Vendedor1"},{_id:1})
	});


db.Venda.aggregate({
   $lookup:
     {
       from: Venedor,
       localField: IdVenedor,
       foreignField: _id,
       as: IdVenedor
     }
}
);


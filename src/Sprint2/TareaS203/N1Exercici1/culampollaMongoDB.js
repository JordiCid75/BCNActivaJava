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
var ulleres = db.ulleres.insertOne({
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
var v1 = db.Venedor.insertOne({
  nom: "Vendedor1"
});

var ullerainsertada = ulleres.insertedId;
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
  id_ullera: [ullerainsertada]
});

// Clientes
var c1 = db.Clientes.insertOne({
  nom: "Cliente1",
  adressa: "Calle Cliente",
  telefon: "987654321",
  email: "cliente1@example.com",
  dataRegistre: new Date(),
});
var c1ins = c1.insertedId;
var c2 = db.Clientes.insertOne({
  nom: "Cliente1",
  adressa: "Calle Cliente",
  telefon: "987654321",
  email: "cliente1@example.com",
  dataRegistre: new Date(),
  ClientRecomanat: c1ins
});


// Venda
var v1ins = v1.insertedId;
db.Venda.insertOne({
  id_ullera: [ullerainsertada],
  idClient: c1ins,
  idVenedor: v1ins
});


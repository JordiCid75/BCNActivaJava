db.Restaurante.find();
db.Restaurante.find({},{restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({},{_id:0, restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({},{_id:0, restaurant_id:1, name:1, borough:1, "address.zipcode":1});
db.Restaurante.find({borough:"Bronx"});
db.Restaurante.find({borough:"Bronx"}).limit(5);
db.Restaurante.find({borough:"Bronx"}).limit(5).skip(5);
db.Restaurante.find({"grades.score":{$gt: 90}});
db.Restaurante.find({"grades.score":{$gt: 80, $lt:100}});
db.Restaurante.find({"address.coord.0":{$lt: -95.754168}});
db.Restaurante.find({$and:[{cuisine:{$ne: "American "}}, {"grades.score":{$gt:70}}, {"address.coord.0":{$lt: -65.754168}}]});
db.Restaurante.find({cuisine: { $ne: "American " }, "grades.score": { $gt:70}, "address.coord.0": {$lt: -65.754168}});
db.Restaurante.find({cuisine: { $ne: "American " }, "grades.grade": "A", borough: {$ne: "Brooklyn"}}).sort({cuisine: -1});
db.Restaurante.find({name:{$regex: /^Wil/}},{restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({name:{$regex: /ces$/}},{restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({name:{$regex: /Reg/}},{restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({$and:[{$or: [{cuisine: "Chinese"},{cuisine: "American "}], borough: "Bronx"}]});
db.Restaurante.find({borough:{$in: ["Staten Island","Queens","Bronx", "Brooklyn"]}},{restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({borough:{$nin: ["Staten Island","Queens","Bronx", "Brooklyn"]}},{restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({"grades.score": { $lt: 10 }},{grades:1,restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({$or:[{cuisine:{$nin: ["American ","Chinese"]}},{name:{$regex: /^Wil/}}]},{restaurant_id:1, name:1, borough:1, cuisine:1});
db.Restaurante.find({"grades.date": new Date("2014-08-11T00:00:00Z"),"grades.grade": "A", "grades.score":11},{restaurant_id:1, name:1, grades:1});
db.Restaurante.find({"grades.9.date": new Date("2014-08-11T00:00:00Z"),"grades.2.grade": "A"},{restaurant_id:1, name:1, grades:1});
db.Restaurante.find({"address.coord.1":{$gt: 42, $lt: 52}},{restaurant_id:1, name:1, address:1});
db.Restaurante.find({}).sort({name:1,all:1});
db.Restaurante.find({}).sort({name:-1,all:-1});
db.Restaurante.find({}).sort({cuisine:1,borough:-1});
db.Restaurante.find({"address.street":{$exists:false}});
db.Restaurante.find({"address.coord":{$type:"double"}});
db.Restaurante.find({"grades.score": {$mod:[7,0]}},{restaurant_id:1, name:1, grades:1});
db.Restaurante.find({name:{$regex: /Mad/}},{name:1, borough:1, "address.coord":1, cuisine:1});







 
 install firefox
 rest client
 loging first
 then do post from rest client
 
 "io.swagger" % "swagger-core" % "1.5.8",
 "io.swagger" %% "swagger-scala-module" % "1.0.2"
  "com.wordnik" %% "swagger-play2" % "1.3.11",
  
  
 
 db.posts.insert({
      "text" : "Have you heard about the Web Components revolution?",
      "username" : "Eric",
      "avatar" : "../images/avatar-01.svg",
      "favorite" : false
    })
    
    
    
    
db.posts.insert({"text" : "Loving this Polymer thing.",
      "username" : "Rob",
      "avatar" : "../images/avatar-02.svg",
      "favorite" : false
    })
    
    
    
    
    Json.obj({
      "text" : "So last year...",
      "username" : "Dimitri",
      "avatar" : "../images/avatar-03.svg",
      "favorite" : false
    }),
    
db.posts.insert({"text" : "Yo, I heard you like components, so I put a component in your component.",
      "username" : "Grace",
      "avatar" : "../images/avatar-08.svg",
      "favorite" : false
    })
    


db.posts.find({"username" : "Grace"})
{ "_id" : ObjectId("57d9724d64e1c11decf490ce"), "text" : "Yo. I heard you like components, so I put a component in yours", "username" : "Grace", "avatar" : "../images/avatar-08.svg", "favorite" : false }
>

db.posts.find({ "_id" : ObjectId("57e3eb83cf8c9b9bb264b77c")})
{ "_id" : ObjectId("57d9724d64e1c11decf490ce"), "text" : "Yo. I heard you like components, so I put a component in yours", "username" : "Grace", "avatar" : "../images/avatar-08.svg", "favorite" : false }
works


db.posts.find({ "id" : "57d9724d64e1c11decf490ce"})

db.posts.find({"_id":{"$oid":"57d9724d64e1c11decf490ce"}})

> db.posts.remove({"_id" : ObjectId("57d803467c8069fcad0cd184")})
WriteResult({ "nRemoved" : 1 })


> songid_1 = ObjectId()
ObjectId("57e545c6dd70e6c61878976e")
> songid_2 = ObjectId()
ObjectId("57e545d6dd70e6c61878976f")
> songid_3 = ObjectId()
ObjectId("57e545e3dd70e6c618789770")
> songid_4 = ObjectId()
ObjectId("57e54602dd70e6c618789771")



db.songs.insert({"_id" : songid_1, "title" : "Connect", "duration" : 154, "writer" : "Phil Collins"})
WriteResult({ "nInserted" : 1 })
> db.songs.insert({"_id" : songid_2, "title" : "Change the World", "duration" : 149, "writer" : "Kevin Williams"})
WriteResult({ "nInserted" : 1 })
> db.songs.insert({"_id" : songid_3, "title" : "Once in a Lifetime", "duration" : 160, "writer" : "Garrett Brisby"})
WriteResult({ "nInserted" : 1 })
> db.songs.insert({"_id" : songid_4, "title" : "Holier than Thou", "duration" : 152, "writer" : "Jayden Haijou"})
WriteResult({ "nInserted" : 1 })



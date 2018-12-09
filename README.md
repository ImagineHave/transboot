# transboot

# localhost:8080/user

{
	"id" : {"userName": "some username", "email": "this@blah.com"},
	"password": "this is a password"
}

# localhost:8080/account

{
	"accountName": "another account name",
	"openedDate": "20180101",
	"transectUser": { "id": {"userName": "some username", "email": "this@blah.com"}}
}

# localhost:8080/accounts

[{
	"accountName": "another account name",
	"openedDate": "20180101",
	"transectUser": { "id": {"userName": "some username", "email": "this@blah.com"}}
},
{
	"accountName": "some account name",
	"openedDate": "20180101",
	"transectUser": { "id": {"userName": "some username", "email": "this@blah.com"}}
}
]

# localhost:8080/transaction

{ 
	"id":{
		"date":"20181209",
		"transectUser": { 
			"id": {
				"userName": "some username", 
				"email": "this@blah.com"
			}
		},
		"payer":{"accountName":"some account name"},
		"payee":{"accountName":"another account name"}
	},
	"amount":1000
}

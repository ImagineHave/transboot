# transboot

# localhost:8080/users/create

{
	"userName": "some username"
}

# localhost:8080/accounts/bulk_create

[{
	"accountName": "another account name",
	"openedDate": "20180101",
	"transectUser": {"userName": "some username", "id": "1"}
},
{
	"accountName": "some account name",
	"openedDate": "20180102",
	"transectUser": {"userName": "some username", "id": "1"}
}
]


# localhost:8080/transactions/create

{
	"amount":1000,
	"date":"20181209",
	"transectUser": {"userName": "some username", "id": "1"},
	"payer":{"accountName":"some account name", "id":2},
	"payee":{"accountName":"another account name", "id":1}
}

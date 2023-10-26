const express = require('express');
const { MongoClient } = require('mongodb'); // Import MongoClient from 'mongodb'
const app = express();
const Database = require('./database');
const DataAccess = require('./dataAccess');

// MongoDB connection URL
const uri = "mongodb+srv://cs482:QIXLdzWohiJXgMLPe2gGjggySJekVfw4CWojBEktgE1IvY2cnP1oWsERgieNOKN@cluster.mongodb.net/test?retryWrites=true&w=majority";

const client = new MongoClient(uri, { useNewUrlParser: true });

const url = uri; // Use the same MongoDB URL for the server
const dbName = 'sevencarddb';

const database = new Database(url, dbName);
const dataAccess = new DataAccess(database);

// Middleware to validate API key
const validateApiKey = (req, res, next) => {
    const apiKey = req.get('api-key'); // Get the API key from the request headers

    // Replace 'your-api-key' with your actual API key
    if (apiKey === 'QIXLdzWohiJXgMLPe2gGjggySJekVfw4CWojBEktgE1IvY2cnP1oWsERgieNOKN') {
        next(); // API key is valid, continue to the route
    } else {
        res.status(403).json({ error: 'Invalid API key' }); // API key is invalid
    }
};

app.use(express.json()); // Middleware to parse JSON requests

app.get('/retrieveData', validateApiKey, async (req, res) => {
    try {
        await client.connect(); // Connect to MongoDB using the MongoClient
        console.log("Connected to MongoDB");

        const collectionName = 'users';
        const db = client.db(dbName); // Access the database
        const collection = db.collection(collectionName); // Access the collection
        const data = await collection.find({}).toArray(); // Retrieve all documents

        res.json(data);
    } catch (err) {
        res.status(500).json({ error: 'Error retrieving data from the collection' });
    } finally {
        await client.close(); // Close the MongoDB connection
    }
});

const port = process.env.PORT || 28017;
app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});

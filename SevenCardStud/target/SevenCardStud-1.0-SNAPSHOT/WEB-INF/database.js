// database.js

const { MongoClient } = require('mongodb');

class Database {
    constructor(url, dbName) {
        this.url = url;
        this.dbName = dbName;
        this.client = new MongoClient(this.url, { useUnifiedTopology: true });
        this.db = null; // Database reference
    }

    async connect() {
        try {
            await this.client.connect();
            this.db = this.client.db(this.dbName);
            console.log(`Connected to the database: ${this.dbName}`);
        } catch (err) {
            console.error('Error connecting to the database:', err);
            throw err;
        }
    }

    async disconnect() {
        try {
            await this.client.close();
            console.log('Disconnected from the database');
        } catch (err) {
            console.error('Error disconnecting from the database:', err);
            throw err;
        }
    }
}

module.exports = Database;

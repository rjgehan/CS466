// dataAccess.js

class DataAccess {
    constructor(database) {
        this.database = database;
    }

    async retrieveDataFromCollection(collectionName) {
        try {
            const collection = this.database.db.collection(collectionName); // Access the specified collection
            const documents = await collection.find({}).toArray(); // Retrieve all documents

            // Log the retrieved documents
            console.log('Retrieved documents:', documents);

            return documents;
        } catch (err) {
            console.error('Error retrieving data from the collection:', err);
            throw err;
        }
    }
}

module.exports = DataAccess;

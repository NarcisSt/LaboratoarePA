# PA Lab 5

Author: Barat Narcis Stefan

Media Catalog

Write an application that can manage a catalog of multimedia items. An entry in this catalog might be a song, a movie, a book, an image or any item that has at least a name and a path in the local file system. (We may also consider specifying a release year, a rating and other additional data, for example the author of the book, etc.)

## Compulsory
- &#9745; Create an object-oriented model of the problem. You should have at least the following classes: Catalog and two item classes at your choice. Consider using an interface or an abstract class in order to describe the items in a catalog.
- &#9745;Implement the following methods representing commands that will manage the content of the catalog: 
    - &#9745;add: adds a new entry into the catalog;
    - &#9745;list: prints the content of the catalog on the screen;
    - &#9745;play: playback using the native operating system application (see the Desktop class);
    - &#9745;save: saves the catalog to an external file (either as a text or binary, using object serialization);
    - &#9745;load: loads the catalog from an external file.
- &#9745; The application will signal invalid data (year, path, etc.) using a custom exception.
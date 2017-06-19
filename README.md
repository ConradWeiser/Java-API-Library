# Java Websocket Connector

A simple file which can be instantiated to handle reading HTML from a given URL, which is then exported to a string.

Quick and dirty.

## Usage

The first available method merely takes a simple URL and returns the contents.

```getApiResponse("url")``` Returns a String

---

The second method uses the [Gson library](https://github.com/google/gson) to parse the URL contents and returns it as a JsonObject.
```getApiResponseAsJsonObject("url")```  Returns a JsonObject

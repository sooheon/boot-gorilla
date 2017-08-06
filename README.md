# boot-gorilla

A Boot task to start [Gorilla REPL](http://gorilla-repl.org/)


## Thanks

This project is a fork of [ckampfe/boot-gorilla](https://github.com/ckampfe/boot-gorilla),
which is a fork of [mathias/boot-gorilla](https://github.com/mathias/boot-gorilla). Thanks
to `mathias` and `ckampfe` for doing the hard work :)


## Usage

To use this in your project, add `[sooheon/boot-gorilla "0.1.1-SNAPSHOT"]` to your `:dependencies`
and then require the task: `(require '[sooheon.boot-gorilla :refer [gorilla]])`

Run the task from your project directly like: `boot gorilla -b`

`boot gorilla -h` looks like:

```
Start the gorilla-repl server

Options:
  -h, --help             Print this help info.
  -p, --port PORT        PORT sets the port to run the web REPL on. Defaults to 4000.
  -i, --ip IP            IP sets the IP address the server listens on. Defaults to 127.0.0.1.
  -n, --nrepl-port PORT  PORT sets the port that the nREPL server will be started up on. Defaults to a free port.
  -b, --block            Blocking (for standalone use)
```


## License

Copyright © 2017

Distributed under the Eclipse Public License either version 1.0 or (at your option) any
later version.

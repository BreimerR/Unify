# Imports

## Simple import
```unify
# imports unpackaged content relative to project root/ where main method is at.
imoprt <path to file>.fileNameWithoutExtension
```

```unify
import packageName.<className>
```

## Import As
```unify
import packageName.name as otherName
```

## Namespace Like design
Unify retains the package structure 
but does provide a namespace design import
if need be i.e

```unify
imoprt identifier.identifier.* as IO
```
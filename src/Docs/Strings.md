# Strings


## Comparison
#### Regular expression based comparison
```
val string = "development"
string similarTo "dev*"

// this is a more prefered syntax compared to 
// the first two and makes more sense
string ~= "dev*"
```
# Wikipedia Matrix (benchmark)

This project aim at extracting csv table from wikipedia articles.  Indee, wikipedia articles are hard to use with statistical software as RStudio, Excel or OpenOffice. 

We give 300+ Wikipedia URLs and the challenge is to:
 * integrate the extractors' code 
 * extract as many relevant tables as possible 
 * serialize the results into CSV files 
 
We are expecting to launch `mvn test` and the results will be in `output` folder 


## Installation

As this project use maven, it is simple to install. 
In order to install it, one should download the code, then Open it in an IDE, then update the project with Maven. 
For exemple, in Eclipse, one should go on File > Open project from File System. Then, in their workspace, do a right click on the project and select Maven > update project. 

In order to use the benchmark, please do, once the git is cloned:
```
cd wikimatrix 
mvn test
``` 

## Architecture

![Class diagram](/wikimatrixDiagram.png)

## License

This project is under [MIT](https://choosealicense.com/licenses/mit/) license which means that : 

- it may be use for commercial purposes
- it may be distributed
- it may be modified 
- it may be used and modified for a private usage

subject to the condition that the copyright notice is included. 

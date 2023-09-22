
# mirror

Mirror is a powerful android library that allows you to effortlessly create stunning mirror effects on images in your android applications. Whether you're building a photo editing app or simply want to add a unique touch to your images, mirror is the perfect jetpack compose tool for the job.


## Tech Stack

- Kotlin
- Jetpack Compose
- Material Design 3




## Installation

You can add the library to your project using jitpack.io

- Add the code below to your project's `settings.gradle` file

```bash
repositories {
    ...
    maven { url "https://jitpack.io" }
}
```
- In `build.gradle` of app module, include this dependency
```bash
  
dependencies {
    implementation 'com.github.SubhadeepSantra1998:mirror:$latest_version'
}
```
## Usage

Wrap the content to display mirror effect in `Mirror`

```bash
Mirror(
    content = {
        //your composable
    }
)
```

## Example

```bash
// images are taken from Pixabay website: "https://pixabay.com/"

val imageUrls = listOf(
    "https://cdn.pixabay.com/photo/2013/11/28/10/36/road-220058_1280.jpg", 
    "https://cdn.pixabay.com/photo/2023/07/22/10/50/ship-8143169_1280.jpg",
    "https://cdn.pixabay.com/photo/2018/04/12/15/51/nature-3313832_1280.jpg",
    "https://cdn.pixabay.com/photo/2016/10/09/05/49/autumn-1725205_1280.jpg",
)

Scaffold(
modifier = Modifier
.fillMaxSize(),
topBar = {
    TopAppBar(
        title = {
            Text(text = "Mirror Efect")
        }
    )
}
) { paddingValue ->

    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValue)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        items(imageUrls) { url ->

            Mirror(
                content = {
                    Image(
                        painter = rememberCoilPainter(
                            request = ImageRequest.Builder(LocalContext.current)
                                .crossfade(durationMillis = 1000)
                                .data(url)
                                .placeholder(R.drawable.ic_placeholder)
                                .error(R.drawable.ic_placeholder)
                                .build()
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .height(300.dp)
                            .clip(RoundedCornerShape(14.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    }
}
```



## Screenshots

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://github.com/SubhadeepSantra1998/mirror/assets/68366982/783cb8f5-ca56-4d58-b27b-f0f0f22ff290" width="200px" alt="Image 1">
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://github.com/SubhadeepSantra1998/mirror/assets/68366982/b3ad9c1a-0b45-4565-a444-4c52ee9df00b" width="200px" alt="Image 2">
      </a>
    </td>
  </tr>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://github.com/SubhadeepSantra1998/mirror/assets/68366982/d2706cb0-4964-4756-bd4a-4474b17a988f" width="200px" alt="Image 3">
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://github.com/SubhadeepSantra1998/mirror/assets/68366982/3ed3f0a0-5695-42d1-a657-5d513b5838c6" width="200px" alt="Image 4">
      </a>
    </td>
  </tr>
</table>


## Customization

The opacity of the `Mirror` can be changed according to the needs

```bash
Mirror(
    opacity = 0.60f,
    content = {
        //your composable
    }
)
```
## Find this library useful? :heart:
Support it by joining __[stargazers](https://github.com/SubhadeepSantra1998/mirror/stargazers)__ for this repository. :star: <br>
Also, follow me on __[github](https://github.com/SubhadeepSantra1998)__ and __[linkedIn](https://www.linkedin.com/in/subhadeep-santra-b006581b5/)__ to stay updated with my projects! 🤩



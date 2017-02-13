var images = ["http://i.imgur.com/MXU9gTj.jpg", "http://goo.gl/SXBc1e", "http://goo.gl/1WDts8"];

for (var i = 0; i < images.length; i++){
	var oImg = document.createElement("img");
	oImg.setAttribute('src', images[i]);
	oImg.setAttribute('id', 'pics');
	document.body.appendChild(oImg);
}

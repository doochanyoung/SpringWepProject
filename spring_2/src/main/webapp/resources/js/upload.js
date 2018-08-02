function checkImageType(fileName){
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}

function getFileInfo(fullName){
	var fileName, imgsrc, getLink;
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/displayFile?fileName="+fullName;
		console.log(imgsrc);
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0, 12); // /2018/00/00
		var end = fullName.substr(14);
		getLink = "/displayFile?fileName=" + front + end;
		console.log(getLink);
	}else{
		imgsrc = "/resource/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/displayFile?fileName="+fullName;
	}
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	console.log(fileName);
	console.log(imgsrc);
	return {fileName: fileName, imgsrc:imgsrc, getLink:getLink, fullName:fullName};
}
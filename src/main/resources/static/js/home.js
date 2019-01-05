var movieRankingListJSON;

function onLoad() {
    processMoviesJSON();
}

function processMoviesJSON() {
    movieRankingListJSON = document.getElementById("movieRankingListJSONSpan").innerHTML;
}

function populateSlider() {
    var slider = document.getElementById("sliderBar");
    console.log(movieRankingListJSON);
}

function handleContentTableClick(id) {
    window.location.href = "/moviesforum/thread/" + id;
}
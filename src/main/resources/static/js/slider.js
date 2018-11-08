var movieRankingListJSON;

function processMoviesJSON() {
    movieRankingListJSON = document.getElementById("movieRankingListJSONSpan").innerHTML;
}

function populateSlider() {
    var slider = document.getElementById("sliderBar");
    console.log(movieRankingListJSON);
}
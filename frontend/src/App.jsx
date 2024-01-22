import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [movies, setMovies] = useState([]);
  const [newMovieTitle, setNewMovieTitle] = useState("");
  const [needsReload, setNeedsReload] = useState(true);
  const URL = "http://localhost:9000/movies"

  useEffect(() => {
    if (needsReload) {
      fetch(URL)
        .then(response => response.json())
        .then(data => {
          setMovies(data);
          setNeedsReload(false);
        })
    }
  }, [needsReload]);

  const postMovie = (e) => {
    e.preventDefault();

    const options = {
      method: 'POST',
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title: newMovieTitle })
    };
    fetch(URL, options)
      .then(response => {
        if (response.ok) {
          setNewMovieTitle("");
          setNeedsReload(true);
        }
      })
  }

  return <>
    <form onSubmit={postMovie}>
      <label htmlFor='title'>
        Title
        <input name='title' type='text' value={newMovieTitle} onChange={e => setNewMovieTitle(e.target.value)} />
      </label>
      <input disabled={newMovieTitle === ""} type='submit' value="Create" />
    </form>
    <ul>
      {movies.map(movie => <li key={movie.id}>{`${movie.title} (${movie.id})`}</li>)}
    </ul>
  </>;
}

export default App

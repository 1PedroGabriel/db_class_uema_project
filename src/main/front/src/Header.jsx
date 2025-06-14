import './Header.css'
import HeaderButtons from "./HeaderButtons";



export default function Header(){
  return (
    <header className="app-header">
      <div>
        <h1>LibraryHub</h1>
      </div>

      <HeaderButtons />

    </header>
  )
}
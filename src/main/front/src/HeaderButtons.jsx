import AppButton from "./Button";
import './HeaderButtons.css'

export default function HeaderButtons(){
  return (
    <div className="app-header-buttons">
      <AppButton name="Book Catalog" action={() => console.log("Book Catalog")} />
      <AppButton name="My Books" action={() => console.log("My Books")} />
    </div>
  )
}
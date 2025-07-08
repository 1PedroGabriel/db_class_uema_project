
import './Button.css'

export default function AppButton({name, action, }) {
    
  return (
    <>
        <div className='app-button-div'>
            <button className='app-button' onClick={action}><h1>{name}</h1></button>
        </div>
    </>
  )
}

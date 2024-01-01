
interface ButtonProps {
    text: String;
    onPressed : Function;
}

export default function Button({ text, onPressed } : ButtonProps) {
    return (
        <>
        <button onClick={() => onPressed()}>{text}</button>
        </>
    )
}
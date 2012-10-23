hput () {
  eval hash"$1"='$2'
}

hget () {
  eval echo '${hash'"$1"'#hash}'
}
hput France Paris
hput Netherlands Amsterdam
hput Spain Madrid
hput Spain Madrid
echo `hget France` and `hget Netherlands` and `hget Spain`

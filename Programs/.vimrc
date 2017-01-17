" Color scheme
syntax enable

" Set tabs to 4 spaces
set tabstop=4
set softtabstop=4
set shiftwidth=4
set expandtab

" UI Config
set number
set showcmd 
filetype indent on
set lazyredraw
set showmatch
set hidden
set backspace=indent,eol,start


" Searching
set incsearch
set hlsearch
nnoremap <leader><space> :nohlsearch<CR> " Unhighlight using <leader><space> 

" Folds
set foldenable
set foldlevelstart=10
set foldnestmax=10
set foldmethod=indent
